/*
 *   _____                                 ___       __  __ ____
 *  / ___/__  __ _  __ _  ___  ___  ___   / _ |__ __/ /_/ //_  /
 * / /__/ _ \/  ' \/  ' \/ _ \/ _ \(_-<  / __ / // / __/ _ \/ /_
 * \___/\___/_/_/_/_/_/_/\___/_//_/___/ /_/ |_\_,_/\__/_//_/___/
 *
 *                                              (c) 2017 BMW AG
 */
package com.banking.services.api.providers;

import javax.ws.rs.NameBinding;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@NameBinding
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface JwtAuth {
}
