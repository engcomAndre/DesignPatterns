package com.dp.creational.singleton.spring;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class BasicScopedSingletonService {
}
