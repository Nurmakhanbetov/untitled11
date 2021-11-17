package com.company;

public class Main {

    public static void main(String[] args) {
        Tree tree1 = new Tree("Ель");
        Tree tree2 = new Tree("Сосна");

        System.out.println(tree1);
        System.out.println(tree2);

        tree1.fall();
        tree2.bloom();
        tree1.yellowed();
        tree2.yellowed();
        tree2.snow();

        System.out.println(tree1.equals(tree2));
    }

    public static class Tree {
        private String name;
        private Vetka vetka;
        private List list;

        public Tree(String name){
            this.name = name;
            this.vetka = new Vetka();
            this.list = new List();
        }

        public void bloom(){
            System.out.println(name + ": Зацвело");
        }

        public void fall(){
            vetka.fallist(name);
        }

        public void snow(){
            list.snowed(name);
        }

        public void yellowed(){
            list.yell(name);
        }
        
        @Override
        public boolean equals(Object obj){
            if (this == obj)
                return true;

            Tree tree = (Tree) obj;

            if (obj == null || getClass() != obj.getClass()) return false;

            if(!vetka.equals(tree.vetka))
                return false;

            if(!list.equals(tree.list))
                return false;

            return name.equals(tree.name);
        }

        @Override
        public int hashCode(){
            int result = vetka.hashCode() + list.hashCode();
            result = 23 * result + name.hashCode();
            return result;
        }

        @Override
        public String toString(){
            return "Дерево: " + name;
        }

    }

    public static class Vetka {
        public void fallist(String name){
            System.out.println(name + ": C веток опали листья");
        }
    }

    public static class List {
        public void snowed(String name){
            System.out.println(name + ": Листья покрылись инеем");
        }

        public void yell(String name){
            if (name.equals("Ель"))
                System.out.println(name + ": Листья Ели не желтеют");
            else
                System.out.println(name + ": Листья пожелтели");
        }
    }
}