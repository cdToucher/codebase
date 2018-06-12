package cn.com.duiba.listener

import cn.com.duiba.plugins.CheckjarsPlugin
import org.gradle.api.Project
import org.gradle.api.Task
import org.gradle.api.execution.TaskExecutionListener
import org.gradle.api.tasks.TaskState
import org.gradle.language.base.plugins.LifecycleBasePlugin
/**
 * Created by gyf .
 * 2017/12/18 .
 */
class LifecycleListener implements TaskExecutionListener {

    static LifecycleListener listen(Project project) {
        // 当前目录为项目根目录的时候，为gradle增加一个生命周期监听器
        if (project.rootProject.name.equals(project.name)) {
            project.gradle.addListener(new LifecycleListener())
        }
    }

    @Override
    void beforeExecute(Task task) {
        // 当前执行任务为 build 的时候，执行checkjars内容
        if (LifecycleBasePlugin.BUILD_TASK_NAME.equals(task.getName())) {
            CheckjarsPlugin.doCheck(task.getProject())
        }
    }

    @Override
    void afterExecute(Task task, TaskState state) {
    }
}
