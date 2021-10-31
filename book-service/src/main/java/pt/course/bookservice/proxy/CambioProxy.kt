package pt.course.bookservice.proxy

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import pt.course.bookservice.response.Cambio

@FeignClient(name = "cambio-service")
interface CambioProxy {


    @GetMapping(value = arrayOf("/cambio-service/{amount}/{from}/{to}"))
    fun getCambio( @PathVariable("amount") amount:Double, @PathVariable("from") from:String, @PathVariable("to") to:String): Cambio
}