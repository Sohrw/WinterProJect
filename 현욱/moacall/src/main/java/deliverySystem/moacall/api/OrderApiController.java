package deliverySystem.moacall.api;


import deliverySystem.moacall.domain.Address;
import deliverySystem.moacall.domain.Order;
import deliverySystem.moacall.domain.OrderStatus;
import deliverySystem.moacall.repository.OrderRepository;
import deliverySystem.moacall.repository.OrderSearch;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class OrderApiController {

    private final OrderRepository orderRepository;

    @GetMapping("/api/orders")
    public List<OrderDto> orderDtoList() {
        List<Order> orders = orderRepository.findAll(new OrderSearch());

        return orders.stream()
                .map(o -> new OrderDto(o))
                .collect(Collectors.toList());


    }

    @GetMapping("/api/orders/{memberId}")
    public List<OrderDto> orderDtoListForMember(@PathVariable("memberId") Long memberId)
    {
        List<Order> allWithMember = orderRepository.findAllWithMember();
        return allWithMember.stream()
                .map(o-> new OrderDto(o))
                .collect(Collectors.toList());
    }

    @Getter @Data
    static class OrderDto {
        private Long orderId;
        private Long memberId;
        private String foodName;
        private LocalDateTime orderDate;
        private OrderStatus orderStatus;
        private Address clientAddress;
        private int totalPrice;
        private int deliveryPrice;
        private String memo;
        private double distance;

        public OrderDto(Order order) {
            orderId = order.getId();
            memberId = order.getMember().getId();
            foodName = order.getMember().getName();
            orderDate = order.getOrderDateTime();
            orderStatus = order.getOrderStatus();
            clientAddress = order.getClientAddress();
            totalPrice = order.getTotalPrice();
            deliveryPrice = order.getDeliveryPrice();
            memo = order.getMemo();
            distance = order.getDistance();


        }

    }
}
