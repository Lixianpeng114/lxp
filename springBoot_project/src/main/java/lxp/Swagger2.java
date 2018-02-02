package lxp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2 {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .tags(new Tag("default","默认"), getTags())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.wm.bj"))
                .paths(PathSelectors.any())
                .build();
    }
    
    private Tag[] getTags() {
        Tag[] tags = {
            new Tag("api-city", "地区相关"),
            new Tag("api-promotion", "团购活动相关"),
            new Tag("api-user", "用户相关"),
            new Tag("api-product", "商品相关"),
            new Tag("api-common", "其他接口"),
            new Tag("api-order", "订单相关"),
            new Tag("api-pay", "支付相关"),
            new Tag("api-account", "管理员相关"),
            new Tag("api-wx", "微信公众号相关"),
            new Tag("api-coupon", "奖券相关"),
            new Tag("api-store", "体验店相关"),
            new Tag("api-bill", "流水账单"),
            new Tag("api-role", "角色相关"),
            new Tag("api-Inventory","库存管理"),
            new Tag("api-refund","退款相关"),
            new Tag("api-history","历史记录相关"),
            new Tag("api-matter","代码事项相关"),
            new Tag("api-stage","购车阶段相关"),
            new Tag("api-banner","首页KV相关"),
            new Tag("api-posPay","pos支付相关"),
            new Tag("api-contact","合同相关"),
            new Tag("api-InstalmentApply","分期申请审核相关"),
            new Tag("api-certification", "合格证相关"),
        };
		return tags;
	}

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("团购项目API列表")
                .description("更多信息，请查看")
                .termsOfServiceUrl("")
                .contact(new Contact("微萌", "", ""))
                .version("1.0")
                .build();
    }

}
