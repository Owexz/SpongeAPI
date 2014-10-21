/*
 * This file is part of Sponge, licensed under the MIT License (MIT).
 *
 * Copyright (c) SpongePowered.org <http://www.spongepowered.org>
 * Copyright (c) contributors
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package org.spongepowered.api.service.permission;

import com.google.common.base.Optional;
import org.spongepowered.api.service.permission.context.Context;
import org.spongepowered.api.service.permission.context.ContextCalculator;

import java.util.UUID;

/**
 * Represents a provider for permissions
 * Example:
 *
 * provide
 */
public interface PermissionService {
    public static final String SUBJECTS_USER = "user", SUBJECTS_GROUP = "group";

    /**
     * Returns the permissions level that describes users.
     * User identifiers are expected to be UUIDs in RFC4122 string format (This *does* have dashes. Mojang is stupid.)
     *
     *
     * @return A subject collection for users
     */
    public SubjectCollection getUserSubjects();

    /**
     * Returns the collection of group subjects available. Implementation of this method is optional.
     * @return Known group subjects
     */
    public SubjectCollection getGroupSubjects();

    public void registerContextCalculator(ContextCalculator calculator);

    /**
     * Returns a subject collection with the given identifier
     *
     * @param identifier The identifier
     * @param parentCollection The type of parent. If null is provided, this collection will use its own subjects as the parent type
     * @return
     */
    public <I, P> Optional<SubjectCollection> getSubjects(String identifier, SubjectCollection parentCollection);
}
