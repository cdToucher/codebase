package cn.com.duiba;

import cn.com.duiba.utils.JarUtils;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps;
import org.apache.commons.lang.StringUtils;

import java.io.File;
import java.util.*;

/**
 * Created by gyf .
 * 2017/12/12 .
 */
public class CheckJars {

    private static final String START_MSG = ":开始检查jar冲突\r\n";
    private static final String END_TMSG = "\r\n:jar冲突检查完成\r\n";
    private static final String JAR_HEADER_MSG = "\r\nWARN: 检测到以下多个jar冲突: \r\n";
    private static final String JAR_MSG = "\t--:%s\r\n";
    private static final String CLASS_HEADER_MSG = "      冲突的class如下\r\n";
    private static final String CLASS_MSG = "\t--:%s\r\n";
    private static final String CLASS_MORE_MSG = "\t......\r\n";
    private static final String NOTFOUND_MSG = "\r\n--未发现冲突的jar\r\n";

    private static final List<String> WHITE_LIST = Arrays.asList(
            "org/apache/commons/collections",
            "org/apache/commons/logging",
            "org/apache/xbean/recipe",
            "org/apache/juli",
            "io/netty",
            "javax/xml/stream",
            "javax/annotation",
            "javax/ws/rs",
            "org/xmlpull/v1",
            "org/aspectj",
            "org/aopalliance/aop",
            "org/aopalliance/intercept",
            "org/codehaus/plexus/component/builder/XBeanComponentBuilder"
    );

    private CheckJars() {
    }

    /**
     * 用于检查参数传入的所有jar中存在的相同名称的.class
     * @param files gradle compile的时候依赖的所有 jar 文件
     * @param isWhiteMode 白名单模式，部分package不进行检查
     * @return
     */
    public static String check(List<File> files, boolean isWhiteMode) {
        Multimap<String, String> multimap = ArrayListMultimap.create();

        // 根据 className 进行分组，key: className, value: 相同className的file的绝对路径list
        for (File file : files) {
            List<String> classNames = JarUtils.getJarClasses(file.getAbsolutePath());
            for (String className : classNames) {
                // 如果使用白名单模式，并且该 .class 文件所在的包在白名单下，则不进入分组(不进行警告校验)
                if (isWhiteMode && checkWhite(className)) {
                    continue;
                }
                multimap.put(className, file.getAbsolutePath());
            }
        }

        return String.format("%s%s%s", START_MSG, buildWarnMsg(multimap), END_TMSG);
    }

    /**
     * 进行白名单校验，判断该 .class 文件是否在白名单/所在包是否在白名单
     * @param className .class 文件包路径+名称
     * @return
     */
    private static boolean checkWhite(String className) {
        if (StringUtils.isBlank(className)) {
            return false;
        }
        for (String white : WHITE_LIST) {
            if (className.contains(white)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 构建检查结果，用于输出警告
     * @param multimap 分组后的map---根据 className 进行分组，key: className, value: 相同className的file的绝对路径list
     * @return
     */
    private static String buildWarnMsg(Multimap<String, String> multimap) {
        if (multimap == null) {
            return null;
        }

        // 反置 multimap key : jarPath, value : className的list
        Multimap<String, String> invertMap = ArrayListMultimap.create();
        Multimaps.invertFrom(multimap, invertMap);

        Set<WarnMsgModel> models = new HashSet<>();
        WarnMsgModel model;

        for (String className : multimap.keySet()) {
            List<String> jars = new ArrayList<>(multimap.get(className));

            // 判断，如果一个key对应的value长度大于1，则说明一个.class文件在多个包中存在，需要加入到warn信息中
            // 没进入此if，说明此class只存在于一个jar中
            if (jars.size() > 1) {
                // 进入if的需要被打印到控制台
                List<String> cnsResult = new ArrayList<>();

                // 把这个.class所在的所有的jar的list 作为key
                // 然后把这几个jar对应的所有.class文件取交集（交集的内容，就是这几个jar所有冲突的.class）
                for (String jarPath : jars) {
                    List<String> cns = new ArrayList<>(invertMap.get(jarPath));
                    if (cnsResult.isEmpty()) {
                        cnsResult.addAll(cns);
                    } else {
                        cnsResult.retainAll(cns);
                    }
                }

                // 构建结果
                model = new WarnMsgModel();
                model.setJars(jars);
                model.setClassNames(cnsResult);
                models.add(model);
            }
        }

        // 根据 models 构建打印信息
        return innerBuildWarnMsg(models);
    }

    /**
     * 根据models构建打印信息
     * @param models
     * @return
     */
    private static String innerBuildWarnMsg(Set<WarnMsgModel> models) {
        StringBuilder msgBuilder = new StringBuilder();
        for (WarnMsgModel model : models) {
            List<String> jars = model.getJars();
            List<String> classNames = model.getClassNames();
            msgBuilder.append(JAR_HEADER_MSG);
            for (String jar : jars) {
                msgBuilder.append(String.format(JAR_MSG, jar));
            }
            msgBuilder.append(CLASS_HEADER_MSG);
            for (int i = 0; i < classNames.size(); i++) {
                // 当两个jar冲突的时候，很多时候会有大量的.class冲突，为了展示更加清晰，只保留三个展示，更多则展示省略号
                if (i > 2) {
                    msgBuilder.append(CLASS_MORE_MSG);
                    break;
                }
                msgBuilder.append(String.format(CLASS_MSG, classNames.get(i)));
            }
        }
        // 一个都没有，提示没找冲突
        if (msgBuilder.length() == 0) {
            return NOTFOUND_MSG;
        }
        return msgBuilder.toString();
    }

    /**
     * 用于构建warn信息的模型类
     * jars : 范例
     * /Users/gyf/.m2/repository/io/netty/netty-all/4.0.24.Final/netty-all-4.0.24.Final.jar
     * /Users/gyf/.m2/repository/io/netty/netty-transport/4.0.27.Final/netty-transport-4.0.27.Final.jar
     *
     * classNames : 范例
     * io/netty/channel/ChannelHandler.class
     * io/netty/channel/local/LocalChannel$LocalUnsafe.class
     * io/netty/channel/socket/ServerSocketChannel.class
     *
     * jars 如果内容相同（忽略顺序）则认为两个model相同
     */
    private static class WarnMsgModel {

        private List<String> jars;
        private List<String> classNames;

        public WarnMsgModel() {
        }

        public WarnMsgModel(List<String> jars, List<String> classNames) {
            this.jars = jars;
            this.classNames = classNames;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof WarnMsgModel)) {
                return false;
            }

            WarnMsgModel that = (WarnMsgModel) o;
            List<String> thatJars = that.getJars();
            // 长度不同，则一定不同
            if (thatJars.size() != this.jars.size()) {
                return false;
            }

            // that中的每个元素在this中是不是都有，有一个没有，就不同
            for (String it : thatJars) {
                if (!this.jars.contains(it)) {
                    return false;
                }
            }
            return true;
        }

        @Override
        public int hashCode() {
            int hashCode = 0;
            for (String it : jars) {
                hashCode += it.hashCode();
            }
            return hashCode;
        }

        public List<String> getJars() {
            return jars;
        }

        public void setJars(List<String> jars) {
            this.jars = jars;
        }

        public List<String> getClassNames() {
            return classNames;
        }

        public void setClassNames(List<String> classNames) {
            this.classNames = classNames;
        }
    }

    public static void main(String[] args) {
        List<String> jars = new ArrayList<>();
        jars.add("aaa");
        jars.add("bbb");
        List<String> jars2 = new ArrayList<>();
        jars2.add("bbb");
        jars2.add("aaa");
        WarnMsgModel model1 = new WarnMsgModel();
        model1.setJars(jars);
        WarnMsgModel model2 = new WarnMsgModel();
        model2.setJars(jars2);

        System.out.println(model1.equals(model2));
        System.out.println(model1.hashCode());
        System.out.println(model2.hashCode());
    }
}
