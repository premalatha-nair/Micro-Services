# Micro-Services related code

1.  Bean for a Hello worldapp. Create a SpringBoot project. Create DemoApp (main class),Helloworld class and bean.xml .Usebean.xml to inject values.
2. Scope for JavaBean -Singleton scope
<bean id="Helloworld" class="com.example.demo.Helloworld" scope = "singleton">


  Helloworld firstObject =(Helloworld)context.getBean("Helloworld");
		firstObject.getMessage();
		Helloworld secondObject =(Helloworld)context.getBean("Helloworld");
		secondObject.getMessage();
        
        Both the beans willgive the same output.
        3)      
