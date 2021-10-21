package mavenpackage.api;

import java.sql.Date;

import com.google.gson.Gson;

import mavenpackage.api.DTOs.RestrictionsResultDTO;

public class ApiMethods {
    
    public static RestrictionsResultDTO getRestrictions(){
        String callResult = CallsApi.getAPI("GetAllRestrictionBE/2021-11-10/2022-01-11/ZMSU");
        RestrictionsResultDTO restrictionsResult = new Gson().fromJson(callResult, RestrictionsResultDTO.class);
        System.out.println(restrictionsResult);
        return restrictionsResult;
    }

    /*public static RestrictionsDTO getPostDate(Date dateStart, Date dateEnd, String propertyHotel){
        RestrictionsDTO postDateHotel = new Gson().fromJson(CallsApi.getAPI(dateStart + "/" + dateEnd + "/" + propertyHotel), RestrictionsResultDTO.class);
        return postDateHotel;
    }*/
}
