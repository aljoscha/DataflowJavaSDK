/*******************************************************************************
 * Copyright (C) 2014 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 ******************************************************************************/

package com.google.cloud.dataflow.sdk.util.common.worker;

import com.google.cloud.dataflow.sdk.util.common.Reiterator;

import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;

/**
 * ShuffleEntryReader provides an interface for reading key/value
 * entries from a shuffle dataset.
 */
@NotThreadSafe
public interface ShuffleEntryReader {
  /**
   * Returns an iterator which reads a range of entries from a shuffle dataset.
   *
   * @param startPosition encodes the initial key from where to read.
   * This parameter may be null, indicating that the read should start
   * with the first key in the dataset.
   *
   * @param endPosition encodes the key "just past" the end of the
   * range to be read; keys up to endPosition will be returned, but
   * keys equal to or greater than endPosition will not.  This
   * parameter may be null, indicating that the read should end just
   * past the last key in the dataset (that is, the last key in the
   * dataset will be included in the read, as long as that key is
   * greater than or equal to startPosition).
   *
   * @return a {@link Reiterator} over the requested range of entries.
   */
  public Reiterator<ShuffleEntry> read(
      @Nullable ShufflePosition startPosition,
      @Nullable ShufflePosition endPosition);
}
