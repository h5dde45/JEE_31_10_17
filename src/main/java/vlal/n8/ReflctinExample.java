package vlal.n8;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Collection;

public class ReflctinExample {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> multiSetClass = Class.forName("vlal.n8.MultiSetImpl");
        System.out.println(multiSetClass);
        boolean implMS = MultiSet.class.isAssignableFrom(multiSetClass);
        System.out.println(implMS);

        Constructor<?> defaultConstructor=null;
        Constructor<?> collectionConstructor=null;

        for (Constructor<?> constructor:multiSetClass.getConstructors()){
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            if(parameterTypes.length==0){
                defaultConstructor=constructor;
            }else if (parameterTypes.length==1 && parameterTypes[0].equals(Collection.class)){
                collectionConstructor=constructor;
            }
        }
        System.out.println("defaut: "+(defaultConstructor!=null));
        System.out.println("constructor: "+(collectionConstructor!=null));

        Class<?> superclass = multiSetClass.getSuperclass();

        if(!Object.class.equals(superclass)){
            System.out.println(superclass.getCanonicalName());
        }
        System.out.println("fields: ");
        Class<?> currentClass = multiSetClass;

        do{
            for (Field field:currentClass.getDeclaredFields()){
                if((field.getModifiers()& Modifier.STATIC)==0){
                    System.out.println(field.getType().getCanonicalName()+", \n"
                    +field.getName()+", \n"
                    +currentClass.getCanonicalName());
                }
            }
            currentClass=currentClass.getSuperclass();
        }while (!Object.class.equals(currentClass));


    }
}
