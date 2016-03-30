package com.aop;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Date;

//import org.apache.commons.lang3.RandomStringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;

import com.dao.IUserService;
import com.entity.UserActivity;
import com.enums.ProjectEnum;

@Aspect
public class UserActivityLogging implements Serializable{
	

	private static final long serialVersionUID = 1L;
	
    private IUserActivityService userActivityService;
	//private IUserActivityService userActivityService = new UserActivityServiceImpl(new UserActivityDaoImpl());
	private IUserService userService;
	
    @Autowired(required=true)
    @Qualifier(value="userActivityService")
    public void setUserActivityService(IUserActivityService userActivityService){
        this.userActivityService = userActivityService;
    }
    
    @Autowired(required=true)
    @Qualifier(value="userService")
    public void setUserService(IUserService userService){
        this.userService = userService;
    }
	
	@Pointcut("execution(* com.dao.*DaoImpl.add*(..))") // useractivity de extend ederse kendini sonsuz kere çağırıyor
	public void add() {
	}
	@Pointcut("execution(* com.dao.*DaoImpl.update*(..))")
	public void update() {
	}
	@Pointcut("execution(* com.dao.*DaoImpl.remove*(..))")
	public void remove() {
	}
	
	@AfterReturning("remove()")
	public void removeAspect(JoinPoint  joinPoint) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException{
    	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    	if (!(authentication instanceof AnonymousAuthenticationToken)) {
    	    String currentUserName = authentication.getName();
    	    WebAuthenticationDetails details = (WebAuthenticationDetails)authentication.getDetails();
    		//Object[] args = joinPoint.getArgs();
    		Object obj = joinPoint.getArgs()[0];
    		UserActivity userActivity = new UserActivity();
    		userActivity.setAction(ProjectEnum.UserActivityAction.REMOVE);
    	    if (details!=null) {
    	    	String ip = details.getRemoteAddress();
    	    	userActivity.setIp(ip);
			}
    		userActivity.setDetail(obj.toString());
    		userActivity.setTarih(new Date());
    		userActivity.setClassName(obj.getClass().toString());
    		userActivity.setObjectid((Integer)obj);
    		userActivity.setUser(this.userService.getUserByUsername(currentUserName));
    		this.userActivityService.addUserActivity(userActivity);
    	}
	}
	
	
	@AfterReturning("update()")
	public void updateAspect(JoinPoint  joinPoint) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException{
    	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    	if (!(authentication instanceof AnonymousAuthenticationToken)) {
    	    String currentUserName = authentication.getName();
    	    WebAuthenticationDetails details = (WebAuthenticationDetails)authentication.getDetails();
    		//Object[] args = joinPoint.getArgs();
    		Object obj = joinPoint.getArgs()[0];
    		UserActivity userActivity = new UserActivity();
    		userActivity.setAction(ProjectEnum.UserActivityAction.UPDATE);
    	    if (details!=null) {
    	    	String ip = details.getRemoteAddress();
    	    	userActivity.setIp(ip);
			}
    		userActivity.setDetail(obj.toString());
    		userActivity.setTarih(new Date());
    		userActivity.setClassName(obj.getClass().toString());
    		Field field = obj.getClass().getSuperclass().getDeclaredField("id"); 
    		field.setAccessible(true);
    		userActivity.setObjectid((Integer)field.get(obj));
    		field.setAccessible(false);
    		userActivity.setUser(this.userService.getUserByUsername(currentUserName));
    		this.userActivityService.addUserActivity(userActivity);
    	}
	}
	
	
	@AfterReturning("add()")
	public void addAspect(JoinPoint  joinPoint) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException{
    	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    	if (!(authentication instanceof AnonymousAuthenticationToken)) {
    	    String currentUserName = authentication.getName();
    	    WebAuthenticationDetails details = (WebAuthenticationDetails)authentication.getDetails();
    		//Object[] args = joinPoint.getArgs();
    		Object obj = joinPoint.getArgs()[0];
    		UserActivity userActivity = new UserActivity();
    		userActivity.setAction(ProjectEnum.UserActivityAction.ADD);
    	    if (details!=null) {
    	    	String ip = details.getRemoteAddress();
    	    	userActivity.setIp(ip);
			}
    		userActivity.setDetail(obj.toString());
    		userActivity.setTarih(new Date());
    		userActivity.setClassName(obj.getClass().toString());
    		Field field = obj.getClass().getSuperclass().getDeclaredField("id"); 
    		field.setAccessible(true);
    		userActivity.setObjectid((Integer)field.get(obj));
    		field.setAccessible(false);
    		userActivity.setUser(this.userService.getUserByUsername(currentUserName));
    		this.userActivityService.addUserActivity(userActivity);
    		
    		
//    		currentUserName belki idsi, ip,   action add, detay obj.toString(), new Date(),  obj.getClass().getDeclaredField("Id"), obj.getClass(),
    		
    	    
    	   
    	}
    	 
	}
	
	
	
	
//	@Pointcut("execution(* Operation.*(..))")
//	public void k() {
//	}// pointcut name
//
//	@Pointcut("execution(* Operation.save*(..))")
//	public void save() {
//	}// pointcut name
//
//	@Before("k()")
//	// applying pointcut on before advice
//	public void myadvice(JoinPoint jp)// it is advice (before advice)
//	{
//		//System.out.println("additional concern");
//		//System.out.println("Method Signature: " + jp.getSignature());
//	}
//
//	@Around("save()")
//	// applying pointcut on advice
//	public Object saveValidation2(ProceedingJoinPoint joinPoint)
//			throws Throwable {
//		System.out.println("validation started");
//		StringBuilder result = new StringBuilder();
//		Object[] args = joinPoint.getArgs();
//		Object obj = joinPoint.getArgs()[0];
//
//		Field[] fields = obj.getClass().getDeclaredFields();
//		for (Field f : fields) {
//			if (!f.isAccessible()) {
//				f.setAccessible(true);
//				result.append(validate(f, obj));
//				f.setAccessible(false);
//			}
//		}
//		Object retVal = null;
//		if (result.length() != 0) {
//			System.out.println("Hata aldı!");
//			return result.toString();
//		} else {
//			//System.out.println("Method Signature: " + joinPoint.getSignature());
//			retVal = joinPoint.proceed(args);
//			return retVal;
//		}
//	}
//
//	public String validate(Field f, Object obj) throws 
//			IllegalArgumentException, IllegalAccessException {
//		String pattern = null;
//		String validationMessage = "";
//		Boolean required = false;
//		if (f.getName().equals("ad")) {
//			pattern = "[a-zA-Z]{3}";
//			validationMessage = "Üç harf olmalı";
//			required = true;
//		}
//
//		if (f.getName().equals("id")) {
//			pattern = "[a-zA-Z]{3}";
//			validationMessage = "Sayı olmalı";
//		}
//
//		if (f.getName().equals("yas")) {
//			pattern = "[0-9]";
//			validationMessage = "Sayı olmalı";
//		}
//
//		if (!required) {
//			return "";
//		} else {
//			if (f.get(obj) != null && f.get(obj).toString().matches(pattern)) {
//				return "";
//			} else {
//				return validationMessage;
//			}
//		}
//	}
//
//	// returns true if the string contains of three letters
//	public String isThreeLetters(String s) {
//		if (s.matches("[a-zA-Z]{3}")) {
//			return null;
//		} else {
//			return "Üç harf olmalı";
//		}
//	}
//	
//	@AfterReturning("addEmpPointcut() || getEmpPointcut()")
//	public void ourAfterReturningAdvice(){
//	    System.out.println("This is After Returning Advice, called only when method completes its execution succesfully(i.e NO Exception)");
//	    
//	}

}

