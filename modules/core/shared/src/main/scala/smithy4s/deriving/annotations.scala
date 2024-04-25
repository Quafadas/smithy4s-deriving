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

package smithy4s.deriving

import smithy4s.deriving.internals.{MetaAnnotation, ErrorAnnotation}
import smithy4s.{Hint, Hints}

abstract class HintsProvider extends MetaAnnotation {
  def hints: Hints
}
case class hints(first: Hint, others: Hint*) extends HintsProvider {
  def hints: Hints = Hints.fromSeq(first +: others)
}

object hints {

  /**
    * This is useful to make the distinction when annotating an ADT member, to decide whether the hint
    * should go on
    */
  case class onMember(first: Hint, others: Hint*) extends HintsProvider {
    def hints: Hints = Hints.member((first +: others)*)
  }
}

class wrapper() extends MetaAnnotation
class errors[T]() extends ErrorAnnotation[T]
