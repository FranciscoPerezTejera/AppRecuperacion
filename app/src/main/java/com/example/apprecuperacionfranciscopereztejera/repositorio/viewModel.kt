package com.example.apprecuperacionfranciscopereztejera.repositorio

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.apprecuperacionfranciscopereztejera.data.CarServicePro
import com.example.apprecuperacionfranciscopereztejera.model.User
import com.example.apprecuperacionfranciscopereztejera.model.UserDTO
import com.example.apprecuperacionfranciscopereztejera.model.Vehicle
import com.example.apprecuperacionfranciscopereztejera.model.VehicleDTO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

enum class estadoApi {
    IDLE, LOADING, SUCCESS, ERROR
}

class ViewModel : ViewModel() {

    private val _userList: MutableStateFlow<List<User>?> = MutableStateFlow(null)
    var userList = _userList.asStateFlow()

    private val _vehicleList: MutableStateFlow<List<Vehicle>?> = MutableStateFlow(null)
    var vehicleList = _vehicleList.asStateFlow()

    private val _estadoLlamada: MutableStateFlow<estadoApi> = MutableStateFlow(estadoApi.IDLE)
    var estadoLlamada = _estadoLlamada.asStateFlow()

    private val _userEmail: MutableStateFlow<String> = MutableStateFlow("")
    var userEmail = _userEmail.asStateFlow()

    private val _userPassword = MutableStateFlow("")
    var userPassword = _userPassword.asStateFlow()

    private val _brandVehicle: MutableStateFlow<String> = MutableStateFlow("")
    var brandVehicle = _brandVehicle.asStateFlow()

    private val _modelVehicle = MutableStateFlow("")
    var modelVehicle = _modelVehicle.asStateFlow()

    private val _priceVehicle: MutableStateFlow<String> = MutableStateFlow("")
    var priceVehicle = _priceVehicle.asStateFlow()

    private val _imageVehicle = MutableStateFlow("")
    var imageVehicle = _imageVehicle.asStateFlow()

    var _idVehicleUpdate: Int = 0
    var _user: User? = null

    init {
        getAllUsers()
    }

    fun getAllUsers() {
        _estadoLlamada.value = estadoApi.LOADING

        viewModelScope.launch {
            try {
                val service = CarServicePro.RetrofitServiceFactory.makeRetrofitService()
                val response = service.getAllUsers()

                if (response.isSuccessful) {
                    _userList.value = response.body()
                    _estadoLlamada.value = estadoApi.SUCCESS
                } else {
                    _estadoLlamada.value = estadoApi.ERROR
                }
            } catch (e: Exception) {
                _estadoLlamada.value = estadoApi.ERROR
            }
            _estadoLlamada.value = estadoApi.SUCCESS
            Log.e("Valor de State : ", estadoLlamada.value.toString())
        }
    }

    fun getAllVehiclesFromUser() {
        _estadoLlamada.value = estadoApi.LOADING

        viewModelScope.launch {
            try {
                val service = CarServicePro.RetrofitServiceFactory.makeRetrofitService()
                val response = service.getByUsername(_user!!.email)

                if (response.isSuccessful) {
                    _estadoLlamada.value = estadoApi.SUCCESS
                    _vehicleList.value = response.body()?.vehicles
                    for (vehicle in vehicleList.value!!) {
                        Log.e("Vehicle: ", vehicle.toString())
                    }
                } else {
                    _estadoLlamada.value = estadoApi.ERROR
                }
            } catch (e: Exception) {
                _estadoLlamada.value = estadoApi.ERROR
            }
            Log.e("Valor de State : ", estadoLlamada.value.toString())
        }
    }

    fun getVehicleById() : Vehicle? {
        _estadoLlamada.value = estadoApi.LOADING
        var vehicle : Vehicle? = null

        viewModelScope.launch {
            try {
                val service = CarServicePro.RetrofitServiceFactory.makeRetrofitService()
                val response = service.getVehicleById(_idVehicleUpdate)

                if (response.isSuccessful) {
                    _estadoLlamada.value = estadoApi.SUCCESS
                    vehicle = response.body()
                } else {
                    _estadoLlamada.value = estadoApi.ERROR
                }
            } catch (e: Exception) {
                _estadoLlamada.value = estadoApi.ERROR
            }
        }

        return vehicle
    }

    fun addVehicleToUser(vehicle: VehicleDTO) {
        _estadoLlamada.value = estadoApi.LOADING
        Log.e("Nuevo vehiculo: ", vehicle.toString())
        viewModelScope.launch {
            try {
                val service = CarServicePro.RetrofitServiceFactory.makeRetrofitService()
                val response = service.saveVehicle(vehicle)

                if (response.isSuccessful) {
                    getAllVehiclesFromUser()
                    _estadoLlamada.value = estadoApi.SUCCESS
                } else {
                    _estadoLlamada.value = estadoApi.ERROR
                    Log.e("Error de información", response.message())
                }
            } catch(e: Exception) {
                e.message?.let { Log.e("ERROR: ", it) }
            }
        }
    }

    fun deleteVehicleFromUser(id: Int) {
        _estadoLlamada.value = estadoApi.LOADING
        viewModelScope.launch {
            try {
                val service = CarServicePro.RetrofitServiceFactory.makeRetrofitService()
                val response = service.deleteVehicle(id)

                if (response.isSuccessful) {
                    getAllVehiclesFromUser()
                    _estadoLlamada.value = estadoApi.SUCCESS
                } else {
                    Log.d("Error al borrar el vehículo: ", response.errorBody().toString())
                    _estadoLlamada.value = estadoApi.ERROR
                }
            } catch(e: Exception) {
                _estadoLlamada.value = estadoApi.ERROR
            }
        }
    }

    fun updateVehicleFromUser(id: Int, vehicle: Vehicle) {
        /*_estadoLlamada.value = estadoApi.LOADING
        viewModelScope.launch {
            try {
                val service = CarServicePro.RetrofitServiceFactory.makeRetrofitService()
                val vehicleDTO = VehicleDTO(vehicle.brand,vehicle.modelName, vehicle.price, vehicle.imageName, id)
                val response = service.updateVehicle(vehicleDTO)

                if (response.isSuccessful) {
                    getAllVehiclesFromUser()
                    Log.d("Se actualizó el coche con éxito: ", response.message())
                    _estadoLlamada.value = estadoApi.SUCCESS
                } else {
                    Log.d("Error al actualizar el vehículo: ", response.errorBody().toString())
                    _estadoLlamada.value = estadoApi.ERROR
                }
            } catch (e: Exception) {
                Log.d("Error al actualizar un vehículo: ", e.message.toString())
                _estadoLlamada.value = estadoApi.ERROR
            }
        }*/
    }

    fun addUser(user: UserDTO) {

        viewModelScope.launch {
            val service = CarServicePro.RetrofitServiceFactory.makeRetrofitService()
            val response = service.createUser(user)

            if (response.isSuccessful) {
                getAllUsers()
                _estadoLlamada.value = estadoApi.SUCCESS
            } else {
                _estadoLlamada.value = estadoApi.ERROR
                Log.e("Error de información", response.message())
            }
        }
    }

    fun newVehicle(marca: String, modelo: String, precio: Double, imageName: String): VehicleDTO? {
        val vehicle = VehicleDTO(marca, modelo, precio, imageName, _user!!.id)
        Log.e("VEHICLE: ", vehicle.toString())
        return vehicle
    }
}
