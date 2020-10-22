package demo2;


public class Hello extends Hi {
    private Kitty kitty;

    public Hello() {
    }
    
    public void mockParentMethod() {
        super.mockParentMethod();        
        System.out.println("mockParentMethod Hello");
        //super.mockParentMethod();
    }
    public void mockNonStaticMethod() {
        String name = kitty.getName();
        System.out.println("mockNonStaticMethod:" + name);
    }
    
    public void mockStaticMethod() {
        String name = Kitty.getNameStatic();
        System.out.println("mockStaticMethod:" + name);
    }
    
    public void partialMock() {
        _partialMock();
        System.out.println("partialMock");
    }

    private void _partialMock() {
        System.out.println("_partialMock");
    }
    
    public void mockVoidMethod() {
        kitty.say3();
        System.out.println("mockVoidMethod");
    }
    
    public void mockWhenNew() {
    	System.out.println("mock when new start");
    	kitty = new Kitty();
    	this.setKitty(kitty);
    	kitty.say3();
    	System.out.println("mock when new end");
    }

    public Kitty getKitty() {
        return kitty;
    }

    public void setKitty(Kitty kitty) {
        this.kitty = kitty;
        System.out.println("Hello setKitty");
    }
    
}