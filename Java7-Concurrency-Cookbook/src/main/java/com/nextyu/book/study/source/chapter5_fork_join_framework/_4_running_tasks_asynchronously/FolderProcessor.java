package com.nextyu.book.study.source.chapter5_fork_join_framework._4_running_tasks_asynchronously;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

/**
 * @author zhouyu
 */
public class FolderProcessor extends RecursiveTask<List<String>> {

    private static final long serialVersionUID = 1L;

    /**
     * full path of the folder
     */
    private String path;

    /**
     * store the name of the extension of the fies this task
     * is going to look for
     */
    private String extension;

    public FolderProcessor(String path, String extension) {
        this.path = path;
        this.extension = extension;
    }

    @Override
    protected List<String> compute() {
        // store the names of the fies stored in the folder
        List<String> list = new ArrayList<>();

        // store the subtasks that are going to process the subfolders stored in the folder
        List<FolderProcessor> tasks = new ArrayList<>();

        File file = new File(path);
        File[] contents = file.listFiles();
        if (contents != null) {
            for (File content : contents) {
                if (content.isDirectory()) {
                    FolderProcessor task = new FolderProcessor(content.getAbsolutePath(), extension);
                    //  execute it asynchronously using the fork()  method
                    task.fork();
                    tasks.add(task);
                } else {
                    if (checkFile(content.getName())) {
                        list.add(content.getAbsolutePath());
                    }
                }
            }
        }

        if (tasks.size() > 50) {
            System.out.printf("%s: %d tasks ran.\n", file.
                    getAbsolutePath(), tasks.size());
        }


        addResultsFromTasks(list,tasks);

        return list;
    }

    private boolean checkFile(String name) {
        return name.endsWith(extension);
    }

    private void addResultsFromTasks(List<String> list, List<FolderProcessor> tasks) {
        for (FolderProcessor task : tasks) {
            list.addAll(task.join());
        }
    }
}
