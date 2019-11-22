package com.example.springcloudmybaits.dao;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {
    //日志
    private static Logger LOGGER = LoggerFactory.getLogger(LogAspect.class);
    //    Pointcut(切入点):就是带有通知的连接点，在程序中主要体现为书写切入点表达式
    //1）execution(* *(..))
//表示匹配所有方法
            //2）execution(public * com. savage.service.UserService.*(..))
//表示匹配com.savage.server.UserService中所有的公有方法
        //    3）execution(* com.savage.server..*.*(..))
    //表示匹配com.savage.server包及其子包下的所有方法
    @Pointcut("execution(public String com.example.springcloudmybaits.*.*(..))")
    public void poinCut(){};


//    前置通知:在我们执行目标方法之前运行(@Before)
//    后置通知:在我们目标方法运行结束之后 ,不管有没有异常(@After)
//    返回通知:在我们的目标方法正常返回值后运行(@AfterReturning)
//    异常通知:在我们的目标方法出现异常后运行(@AfterThrowing)
//    环绕通知:动态代理, 需要手动执行joinPoint.procced()
//            (其实就是执行我们的目标方法执行之前相当于前置通
//    知, 执行之后就相当于我们后置通知(@Around)

    //@before代表在目标方法执行前切入, 并指定在哪个方法前切入
//    在我们执行目标方法之前运行(@Before)
    @Before("poinCut()")
    public void logStart(JoinPoint joinPoint)throws Throwable{
        LOGGER.info("除法运行....参数列表是:{}");
        System.err.println("除法运行....参数列表是:{}");
    }

    //    后置通知:在我们目标方法运行结束之后 ,不管有没有异常(@After)
     @After("poinCut()")
    public void logEnd(JoinPoint joinPoint){
         LOGGER.info("除法结束");
        System.err.println("除法结束");
    }
    //    返回通知:在我们的目标方法正常返回值后运行(@AfterReturning)
    @AfterReturning("poinCut()")
    public void logReturn(JoinPoint joinPoint){
        LOGGER.info("除法正常返回......运行结果是:{}");
        System.err.println("除法正常返回......运行结果是:{}");
    }
    // 声明ex时指定的类型会限制目标方法必须抛出指定类型的异常
    // 此处将ex的类型声明为Throwable，意味着对目标方法抛出的异常不加限制
    @AfterThrowing(value = "poinCut()",throwing = "ex")
    public void logException(JoinPoint joinPoint,Throwable ex){
        LOGGER.info("运行异常......异常信息是:{}"+ex.getMessage());
        System.err.println("运行异常......异常信息是:{}"+ex.getMessage());
    }

    @Around("poinCut()")
    public Object Around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        System.out.println("@Arount:执行目标方法之前...");
        LOGGER.info("@Arount:执行目标方法之前...");
        Object obj = proceedingJoinPoint.proceed();//相当于开始调div地
        System.out.println("@Arount:执行目标方法之后...");
        LOGGER.info("@Arount:执行目标方法之后...");
        return obj;
    }


}
// logger.info("前置通知");
          //异常所在的类
//    String className = joinPoint.getTarget().getClass().getName();
//         //获取目标方法的参数信息
//         Object[] obj = joinPoint.getArgs();
//         //AOP代理类的信息
//         joinPoint.getThis();
//         //代理的目标对象
//         joinPoint.getTarget();
//         //用的最多 通知的签名
//         Signature signature = joinPoint.getSignature();
//         //代理的是哪一个方法
//         logger.info("代理的是哪一个方法"+signature.getName());
//         //AOP代理类的名字
//         logger.info("AOP代理类的名字"+signature.getDeclaringTypeName());
//         //AOP代理类的类（class）信息
//         signature.getDeclaringType();
//         //获取RequestAttributes
//         RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
//         //从获取RequestAttributes中获取HttpServletRequest的信息
//         HttpServletRequest request = (HttpServletRequest) requestAttributes.resolveReference(RequestAttributes.REFERENCE_REQUEST);
//         //如果要获取Session信息的话，可以这样写：
//         //HttpSession session = (HttpSession) requestAttributes.resolveReference(RequestAttributes.REFERENCE_SESSION);
//         //获取请求参数
//         Enumeration<String> enumeration = request.getParameterNames();
//        Map<String,String> parameterMap = Maps.newHashMap();





//log4j定义了8个级别的log（除去OFF和ALL，可以说分为6个级别），优先级从高到低依次为：OFF、FATAL、ERROR、WARN、INFO、DEBUG、TRACE、 ALL。
//
//        ALL 最低等级的，用于打开所有日志记录。
//
//        TRACE designates finer-grained informational events than the DEBUG.Since:1.2.12，很低的日志级别，一般不会使用。
//
//        DEBUG 指出细粒度信息事件对调试应用程序是非常有帮助的，主要用于开发过程中打印一些运行信息。
//
//        INFO 消息在粗粒度级别上突出强调应用程序的运行过程。打印一些你感兴趣的或者重要的信息，这个可以用于生产环境中输出程序运行的一些重要信息，但是不能滥用，避免打印过多的日志。
//
//        WARN 表明会出现潜在错误的情形，有些信息不是错误信息，但是也要给程序员的一些提示。
//
//        ERROR 指出虽然发生错误事件，但仍然不影响系统的继续运行。打印错误和异常信息，如果不想输出太多的日志，可以使用这个级别。
//
//        FATAL 指出每个严重的错误事件将会导致应用程序的退出。这个级别比较高了。重大错误，这种级别你可以直接停止程序了。
//
//        OFF 最高等级的，用于关闭所有日志记录。
//
//        如果将log level设置在某一个级别上，那么比此级别优先级高的log都能打印出来。例如，如果设置优先级为WARN，那么OFF、FATAL、ERROR、WARN 4个级别的log能正常输出，而INFO、DEBUG、TRACE、 ALL级别的log则会被忽略。Log4j建议只使用四个级别，优先级从高到低分别是ERROR、WARN、INFO、DEBUG。
//
//        从我们实验的结果可以看出，log4j默认的优先级为ERROR或者WARN（实际上是ERROR）。实际上是ERROR