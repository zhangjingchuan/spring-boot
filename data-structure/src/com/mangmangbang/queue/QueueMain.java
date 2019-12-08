package com.mangmangbang.queue;

public class QueueMain {

    public static void main(String [] args){
        ArrayQueue<Integer> queue = new ArrayQueue<>();
        for(int i =0;i<10;i++){
            queue.enqueue(i);
            System.out.println(queue);

            if(i % 3 ==2){
                queue.deQueue();
                System.out.println(queue);
            }
        }
    }
}
