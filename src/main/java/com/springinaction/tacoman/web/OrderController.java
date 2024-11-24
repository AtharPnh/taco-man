package com.springinaction.tacoman.web;

import com.springinaction.tacoman.entity.TacoOrder;
import com.springinaction.tacoman.entity.User;
import com.springinaction.tacoman.repository.TacoOrderRepo;
import com.springinaction.tacoman.repository.UserRepository;
import com.springinaction.tacoman.utilities.OrderProps;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import java.security.Principal;

@Slf4j
@Controller
@RequestMapping("/orders")
@SessionAttributes("tacoOrder")
public class OrderController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TacoOrderRepo orderRepo;

    @Autowired
    private OrderProps props;

    private int pageSize = 20;
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }


    @GetMapping("/current")
    public String orderForm() {
        return "orderForm";
    }

    @PostMapping
    public String processOrder(@Valid TacoOrder order, Errors errors,
                               SessionStatus sessionStatus,
                               //Principal principal
                               //Authentication authentication
                               @AuthenticationPrincipal User user) {
        if (errors.hasErrors()) {
            return "orderForm";
        }

        //User user = userRepository.findByUsername(principal.getName());
        //User user = (User) authentication.getPrincipal();

        order.setUser(user);

        log.info("Order submitted: {}", order);
        sessionStatus.setComplete();
        return "redirect:/";

    }

//    @GetMapping
//    public String ordersForUser(
//            @AuthenticationPrincipal User user, Model model) {
//        Pageable pageable = PageRequest.of(0, 20);
//        model.addAttribute("orders",
//                orderRepo.findByUserOrderByPlacedAtDesc(user, pageable));
//        return "orderList";
//    }

//    @GetMapping
//    public String ordersForUser(
//            @AuthenticationPrincipal User user, Model model) {
//        Pageable pageable = PageRequest.of(0, pageSize);
//        model.addAttribute("orders",
//                orderRepo.findByUserOrderByPlacedAtDesc(user, pageable));
//        return "orderList";
//    }

    @GetMapping
    public String ordersForUser(
            @AuthenticationPrincipal User user, Model model) {
        Pageable pageable = PageRequest.of(0, props.getPageSize());
        model.addAttribute("orders",
                orderRepo.findByUserOrderByPlacedAtDesc(user, pageable));
        return "orderList";
    }
}
