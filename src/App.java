public class App {
    public static void main(String[] args){
        GUI_Main v1 = new GUI_Main();
        GUI_CreateVM v2 = new GUI_CreateVM();
        Factory m1 = new Factory();
        MVC_Controller c = new MVC_Controller(v1,v2,m1);

        c.initController();
    }
}
