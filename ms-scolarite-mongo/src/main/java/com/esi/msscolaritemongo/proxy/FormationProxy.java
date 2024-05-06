package com.esi.msscolaritemongo.proxy;


import com.esi.msscolaritemongo.model.Formation;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="ms-formation-mysql")
@LoadBalancerClient(name="ms-formation-mysql")
public interface FormationProxy {

    @GetMapping("/formations/{id}")
    @CircuitBreaker(name="fall", fallbackMethod = "fallbackFormation" )
    public Formation getFormation(@PathVariable("id") Long idf);
    default Formation fallbackFormation( @PathVariable("id") Long idf,
                                         Throwable throwable){
        if(idf.equals(1L))
            return new Formation(1L,"php",20) ;
        else if(idf.equals(2L))
            return new Formation(2L,"Nodej",30) ;
        return new Formation(3L,"Nekekj",30) ;
    }

  /* get  http://localhost:8081/formations/1
    gerFormation(1)

    get  http://localhost:8081/formations/2
    getFormation(2)*/
}
