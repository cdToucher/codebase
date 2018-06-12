package cn.com.duiba

import cn.com.duiba.plugins.CheckjarsPlugin
import cn.com.duiba.plugins.ExcludeDependenciesPlugin
import org.gradle.api.Plugin
import org.gradle.api.Project

class DuibaGradlePlugin implements Plugin<Project> {

    void apply(Project project) {
        // 增加任务声明周期监听
//        LifecycleListener.listen(project)

        // 增加一个检查jar冲突的命令 gradle checkjars
        CheckjarsPlugin.check(project)

        // 所有子工程都排除相关依赖
        ExcludeDependenciesPlugin.exclude(project)
    }

}
