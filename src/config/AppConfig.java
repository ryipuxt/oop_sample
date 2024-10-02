package config;

import member.repository.MemberRepository;
import member.repository.MemoryMemberRepositoryImpl;
import member.service.MemberService;
import member.service.MemberServiceImpl;
import order.DiscountPolicy;
import order.FixDiscountPolicyImpl;
import order.OrderService;
import order.OrderServiceImpl;
import order.PercentDiscountPolicyImpl;

public class AppConfig {

	public MemberRepository getMemberRepository() {
		return MemoryMemberRepositoryImpl.getInstance();
	}

	public MemberService getMemberService() {
		return new MemberServiceImpl(getMemberRepository());
	}

	public DiscountPolicy getDiscountPolicy() {
		// 할인정책이 변경될 경우
		// return new PercentDiscountPolicyImpl();
		return new FixDiscountPolicyImpl();
	}

	public OrderService getOrderService() {
		return new OrderServiceImpl(getMemberRepository(), getDiscountPolicy());
	}

}
