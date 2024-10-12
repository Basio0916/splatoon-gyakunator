package domain.repositories

import domain.models.Prompt

trait PromptRepository {
    def findAllPrompts(): List[Prompt]
}