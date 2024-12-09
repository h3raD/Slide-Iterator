package com.example.task4;

import javafx.scene.image.Image;

import java.nio.file.Paths;

public class ConcreteAggregate implements
        Aggregate {
    private final String filetopic;
    private Image bi;
    @Override
    public Iterator getIterator() {
        return new ImageIterator();
    }
    public ConcreteAggregate(String filetopic)
    {
        this.filetopic = filetopic;
    }
    private class ImageIterator implements
            Iterator {
        public int current = 1;
        private Image getImage(int iterator){
            String filename =
                    Paths.get("Task4/src/main/resources/Images/"+ filetopic
                            + iterator +".jpg").toUri().toString();
            //System.out.println(filename);
            return new Image(filename);
        }
        @Override
        public boolean hasNext(int i) {
            //System.out.println(getImage(current+1).isError());

         return
                    !getImage(current+i).isError();
        }
        @Override
        public boolean hasPrev(int i) {
            //System.out.println(getImage(current+1).isError());
            return
                    !getImage(current-i).isError();
        }
        @Override
        public Object next() {
            if(this.hasNext(1)) {
                return getImage(++current);
            }
            current = 1;
            return getImage(1);
        }
        @Override
public Object getFirst()
{
    return getImage(1);

}

        @Override
        public Object preview() {
            if(this.hasPrev(1)) {
                return getImage(--current);
            }
            current = 8;
            return getImage(8);
        }
    }
}