/*
 * Copyright 2020 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.cloud.function.time.supplier;

import java.util.Date;
import java.util.function.Supplier;

import org.apache.commons.lang3.time.FastDateFormat;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Soby Chacko
 */
@Configuration
@EnableConfigurationProperties(TimeProperties.class)
public class TimeSupplierConfiguration {

	@Bean
	public Supplier<String> timeSupplier(TimeProperties timeProperties) {
		FastDateFormat fastDateFormat = FastDateFormat.getInstance(timeProperties.getDateFormat());
		return () -> fastDateFormat.format(new Date());
	}

}
