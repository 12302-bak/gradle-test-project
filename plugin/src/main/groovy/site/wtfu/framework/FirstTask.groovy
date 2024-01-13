package site.wtfu.framework

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

class FirstTask extends DefaultTask{

    String msg = 'default'

    FirstTask() {
        group '自定义任务'
        description '任务描述'
    }

    @TaskAction
    void run() {
        println "FirstTask2__$msg"
    }
}