package site.wtfu.framework

import org.gradle.api.Plugin
import org.gradle.api.Project

class Plug implements Plugin<Project> {

    @Override
    void apply(Project project) {
        println "我是自定义插件"

        // 创建扩展
        project.extensions.create('aExtensions',AExtensions)
        // 为aExtensions创建扩展
        project.aExtensions.extensions.create('bExtensions',BExtensions)

        project.afterEvaluate {

            // 获取我们配置的compileSdkVersion与applicationId并打印
            println project.aExtensions.compileSdkVersion
            println project.aExtensions.bExtensions.applicationId

            //创建任务
            FirstTask task = project.tasks.create('firstTask',FirstTask) {
                // 为任务中msg赋值
                msg = project.aExtensions.bExtensions.applicationId
            }

            //添加任务依赖关系
            //project.tasks.getByName('checkDebugManifest').dependsOn task
            project.tasks.getByName('classes').dependsOn task
        }
    }
}