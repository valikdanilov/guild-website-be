package by.danilov.wow.guild.cache

import org.springframework.cache.interceptor.KeyGenerator
import org.springframework.stereotype.Component
import java.lang.reflect.Method

@Component
class ApiRequestKeyGenerator : KeyGenerator {
    override fun generate(target: Any, method: Method, vararg params: Any?): Any {
        var paramsKeyPart = ""
        for (param in params) {
            if (param is String || param is List<*>) {
                paramsKeyPart += "_$param"
            }
        }
        return "${target.javaClass.simpleName}_${method.name}_$paramsKeyPart"
    }
}
