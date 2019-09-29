package be.OneHouseStand.aop;

import org.aspectj.lang.annotation.*;

@Aspect
public class PipoAppelSapLogger {

    @Pointcut("execution(* be.OneHouseStand.springbyexamplepersistence.PersistenceRunner.main(..))")
    public void MakePressOrderLog(){
    }

    @AfterReturning("MakePressOrderLog()")
    public void MarkOrderMade(){
        System.out.println("loggggggggggggggggggggggggggggggggggg");
    }
    /*
    @Pointcut("execution(* Boundary.ControlClientWithFruit.EditPressOrder(..))")
    public void MakeEditPressOrderLog(){

    }


    @Before("MakeEditPressOrderLog()")
    public void MarkOrderEditRequest()
    {
        System.out.println("A client wants to edit his press order");
    }

    @AfterReturning("MakeEditPressOrderLog()")
    public void MarkOrderEditMade(){
        System.out.println("A client has edited his press order");
    }

    @AfterThrowing("MakeEditPressOrderLog()")
    public void MarkOrderEditNotMade(){
        System.out.println("A client has not edited his press order");
    }*/
}