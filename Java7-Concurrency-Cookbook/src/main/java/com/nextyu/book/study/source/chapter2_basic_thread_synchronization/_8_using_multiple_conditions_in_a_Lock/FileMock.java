package com.nextyu.book.study.source.chapter2_basic_thread_synchronization._8_using_multiple_conditions_in_a_Lock;

/**
 * 模拟文本文件
 *
 * @author zhouyu
 */
public class FileMock {
    /**
     * 存储文件内容
     */
    private String[] content;
    /**
     * 被检索到的模拟文件的行数
     */
    private int index;

    public FileMock(int size, int length) {
        content = new String[size];

        for (int i = 0; i < size; i++) {
            StringBuilder builder = new StringBuilder(length);
            for (int j = 0; j < length; j++) {
                int temp = (int) (Math.random() * 255);
                builder.append((char) temp);
            }
            content[i] = builder.toString();
        }

        index = 0;

    }

    /**
     * 返回index属性所确定的行数并增加其值
     *
     * @return
     */
    public String getLine() {
        if (hasMoreLines()) {
            System.out.println("Mock: " + (content.length - index));
            return content[index++];
        }
        return null;
    }

    /**
     * 如果文件有更多的行来处理，则返回true，
     * 如果我们已经取到了模拟文件的尾部，则返回false
     *
     * @return
     */
    public boolean hasMoreLines() {
        return index < content.length;
    }


}
