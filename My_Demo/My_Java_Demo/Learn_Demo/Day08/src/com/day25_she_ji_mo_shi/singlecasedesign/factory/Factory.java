

public class Factory {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("：java Factory ");
            System.exit(1);
        }
        IFruit fruit = Factory2.getInstance(args[0]);
        fruit.eat();
    }
}

class Factory2 {
    public static IFruit getInstance(String className) {
        if ("apple".equals(className)) {
            return new Apple();
        }
        if ("orange".equals(className)) {
            return new Orange();
        }
        return null;
    }
}

class Apple implements IFruit {
    @Override
    public void eat() {
        System.out.println("apple hhhhhhhhhhhhhhh");
    }
}

class Orange implements IFruit {
    @Override
    public void eat() {
        System.out.println("orange oooooooooooooo");
    }
}

interface IFruit {
    public abstract void eat();
}
