/*
 * Copyright 2024 Neandertech
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

package smithy4s.deriving.internals

private[internals] case class IndexedSeqProduct(seq: IndexedSeq[Any]) extends Product {
  def canEqual(that: Any): Boolean = false
  def productArity: Int = seq.size
  def productElement(n: Int): Any = seq(n)
}

private[internals] case class SingletonProduct(value: Any) extends Product {
  def canEqual(that: Any): Boolean = false
  def productArity: Int = 1
  def productElement(n: Int): Any = value
}
