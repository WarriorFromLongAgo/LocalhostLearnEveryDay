package com.day25_she_ji_mo_shi.singlecasedesign.proxydesign;

public class ProxyDesign {
    public static void main(String[] args) {
        ISubject subject = Factory.getInstance();
        subject.save();
    }
}

class Factory {
    public static ISubject getInstance() {
        return new ProxySubject(new RealSubject());
    }
}

class RealSubject implements ISubject {
    @Override
    public void save() {
        System.out.println(" 制止了不法侵害 ");
    }
}

class ProxySubject implements ISubject {
    private ISubject subject;

    public ProxySubject(ISubject subject) {
        this.subject = subject;
    }

    private void broke() {
        System.out.println(" 破门而入 ");
    }

    private void get() {
        System.out.println(" 表彰 ");
    }

    @Override
    public void save() {
        this.broke();
        this.subject.save();
        this.get();
    }

}

interface ISubject {
    public abstract void save();
}
