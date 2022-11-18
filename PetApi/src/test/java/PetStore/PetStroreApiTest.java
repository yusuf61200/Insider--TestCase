package PetStore;

import org.testng.annotations.Test;

import static PetStore.BasePage.BasePage.*;
import static PetStore.Methods.Create.postMethod;
import static PetStore.Methods.Create.postMethodN;
import static PetStore.Methods.Delete.deleteMethod;
import static PetStore.Methods.Read.*;
import static PetStore.Methods.Update.putMethod;

public class PetStroreApiTest {

    @Test
    public static void petEndpoints(){
        postMethod();
        getMethodP();
        putMethod();
        deleteMethod();
    }

    @Test
    public static void petEndpointsN(){
        getMethodN();
        getNotAllowed();
        postMethodN();
    }

}
