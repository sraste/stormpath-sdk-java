/*
 * Copyright 2013 Stormpath, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.stormpath.sdk.client

import com.stormpath.sdk.cache.Caches
import org.testng.annotations.BeforeClass

class ClientIT {

    String apiKeyFileLocation = System.getProperty('user.home') + "/.stormpath/apiKey.properties"
    String baseUrl = 'http://localhost:8080/v1'
    Client client

    @BeforeClass
    void setupClient() {
        client = buildClient();
    }

    Client buildClient() {
        return new ClientBuilder() /*.setBaseUrl(baseUrl) */
                .setApiKeyFileLocation(apiKeyFileLocation)
                .setCacheManager(Caches.newCacheManager().build())
                .build()
    }

    protected static String uniquify(String s) {
        return s + " " + UUID.randomUUID().toString();
    }
}
