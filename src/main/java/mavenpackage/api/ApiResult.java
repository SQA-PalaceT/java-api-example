package mavenpackage.api;

import mavenpackage.api.DTOs.RestrictionsResultDTO;
import mavenpackage.api.DTOs.RestrictionDTO;
import mavenpackage.api.DTOs.HotelRoomPropertiesDTO;

public class ApiResult {

    public static void main(String[] args) {
        
         /** Get Posts*/
         System.out.println("\nPosts example: \n");

        RestrictionsResultDTO restrictionsResult = ApiMethods.getRestrictions();

        for (HotelRoomPropertiesDTO hotelRoomPropertiesItem: restrictionsResult.data){
            for(RestrictionDTO restriction: hotelRoomPropertiesItem.restrictions){
                System.out.println("**" +restriction.date_start+ " **");
                System.out.println("*" +restriction.date_end+ " *");
                System.out.println("*" +restriction.close+ " *");
            }

            System.out.println("*" +hotelRoomPropertiesItem.property+ " *");
            System.out.println("*" +hotelRoomPropertiesItem.room+ " *");
        }

        System.out.println("Restriction type " + restrictionsResult.restriction_type);
    }
    
}