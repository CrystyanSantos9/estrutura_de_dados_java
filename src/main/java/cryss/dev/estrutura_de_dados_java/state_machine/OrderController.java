package cryss.dev.estrutura_de_dados_java.state_machine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("new")
    public String newOrder(){
        orderService.newOrder ();
        return "new Order";
    }

    @PostMapping("pay")
    public String payOrder(){
        orderService.payOrder ();
        return "pay Order";
    }

    @PostMapping("ship")
    public String shipOrder(){
        orderService.shipOrder ();
        return "ship Order";
    }

    @PostMapping("complete")
    public String completeOrder(){
        orderService.completeOrder ();
        return "complete Order";
    }

}
