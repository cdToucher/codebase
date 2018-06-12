package cn.com.duiba.plugins

import cn.com.duiba.CheckJars
import org.gradle.api.Project
import org.gradle.api.Task
/**
 * Created by gyf .
 * 2017/12/18 .
 */
class CheckjarsPlugin {

    private static final String DEFAULT_MODE = "default";
    private static final String ALL_MODE = "all";

    static void check(Project project) {
        Task task = project.task("checkjars")
        task.doLast {
            doCheck(project)
        }
    }

    /**
     * 执行检查jar冲突的操作
     * @param project
     */
    static void doCheck(Project project) {
        boolean useWhiteMode = true     // 默认default 白名单模式
        String mode = project.properties.get("mode");
        if (ALL_MODE.equals(mode)) {
            useWhiteMode = false
        } else if (DEFAULT_MODE.equals(mode)) {
            useWhiteMode = true
        }
        def files = []
        project.configurations.compile.each {
            files.add(it)
        }
        println CheckJars.check(files, useWhiteMode)
    }
}
