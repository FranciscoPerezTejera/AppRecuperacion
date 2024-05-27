package com.example.apprecuperacionfranciscopereztejera.data

import com.example.apprecuperacionfranciscopereztejera.model.User
import com.example.apprecuperacionfranciscopereztejera.model.UserDTO
import com.example.apprecuperacionfranciscopereztejera.model.Vehicle
import com.example.apprecuperacionfranciscopereztejera.model.VehicleDTO
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query

private const val URL = "http://192.168.1.34:8080/"

interface CarServicePro {

    @GET("carservicepro/user/email")
    @Headers("Accept: application/json")
    suspend fun getByUsername(@Query("email") email : String) : Response<User>

    @GET("carservicepro/user")
    @Headers("Accept: application/json")
    suspend fun getAllUsers() : Response<List<User>>

    @GET("carservicepro/vehicle/id")
    @Headers("Accept: application/json")
    suspend fun getVehicleById(@Query("id") id : Int) : Response<Vehicle>

    @POST("carservicepro/vehicle")
    suspend fun saveVehicle(@Body vehicle: VehicleDTO) : Response<Void>

    @POST("carservicepro/user")
    suspend fun createUser(@Body user : UserDTO) : Response<Void>

    @DELETE("carservicepro/vehicle/delete/{id}")
    suspend fun deleteVehicle(@Path("id") id : Int) : Response<Void>

    @PUT("/carservicespro/vehicle")
    suspend fun updateVehicle( @Body vehicle: VehicleDTO) : Response<Void>


    object RetrofitServiceFactory {
        fun makeRetrofitService() : CarServicePro {
            return Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(CarServicePro::class.java)
        }
    }
}
