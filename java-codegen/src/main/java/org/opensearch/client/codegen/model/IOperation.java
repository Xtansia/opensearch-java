/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.model;

import java.util.Collection;
import java.util.HashSet;

public interface IOperation {
    OperationGroup getOperationGroup();

    String getId();

    String getDescription();

    Type getType();

    Type getResponseType();

    default Type getJsonEndpointType() {
        return Types.Client.Transport.JsonEndpoint(
            getType().getWildcarded(),
            getResponseType(),
            Types.Client.OpenSearch._Types.ErrorResponse
        );
    }

    default Collection<Type> getFunctionTypeParameters() {
        var typeParams = new HashSet<Type>();
        typeParams.addAll(getType().getTypeParams());
        typeParams.addAll(getResponseType().getTypeParams());
        return typeParams;
    }

    default String getFunctionTypeParameterDiamond() {
        return Type.getTypeParamsDiamond(getFunctionTypeParameters());
    }

    boolean canBeSingleton();

    boolean hasAnyRequiredFields();
}
