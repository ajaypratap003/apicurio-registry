/*
 * Copyright 2020 Red Hat
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

package io.apicurio.registry.rules.compatibility.jsonschema.wrapper;

import io.apicurio.registry.rules.compatibility.jsonschema.JsonSchemaWrapperVisitor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.everit.json.schema.NotSchema;

import static io.apicurio.registry.rules.compatibility.jsonschema.wrapper.WrapUtil.wrap;

/**
 * @author Jakub Senko 'jsenko@redhat.com'
 */
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class NotSchemaWrapper implements SchemaWrapper {

    @Getter
    @EqualsAndHashCode.Include
    private final NotSchema wrapped;

    public NotSchemaWrapper(NotSchema wrapped) {
        this.wrapped = wrapped;
    }

    @Override
    public void accept(JsonSchemaWrapperVisitor visitor) {
        visitor.visitNotSchema(this);
    }

    public SchemaWrapper getMustNotMatch() {
        return wrap(wrapped.getMustNotMatch());
    }
}