package es.playNcompete.backend.lib.matches;

import lombok.Getter;

/**
 * Enum representing the various states of a match.
 */
@Getter
public enum MatchState {

    /**
     * Match is scheduled but has not yet started.
     */
    SCHEDULED("Scheduled"),

    /**
     * Initial phase of the match, involving preparation or warm-up.
     */
    PREPARATION("Preparation"),

    /**
     * Main phase where the match is actively happening.
     */
    IN_PLAY("In Play"),

    /**
     * Temporary interruption in the match.
     */
    PAUSE("Pause"),

    /**
     * Match has officially ended.
     */
    CONCLUDED("Concluded"),

    /**
     * Waiting for the official announcement of results post-match.
     */
    WAITING_FOR_RESULTS("Waiting for Results"),

    /**
     * Outcomes or results of the event are officially declared.
     */
    RESULTS_ANNOUNCED("Results Announced"),

    /**
     * Period following the match for analysis or review.
     */
    REVIEW("Review"),

    /**
     * Match is completed in all aspects and archived.
     */
    ARCHIVED("Archived"),

    /**
     * Match is cancelled or terminated before its natural conclusion.
     */
    ABORTED("Aborted");

    private final String name;

    MatchState(String name) {
        this.name = name;
    }

    /**
     * Checks if the match is in a pre-event state.
     *
     * @return true if the match is in preparation or scheduled state.
     */
    public boolean isPreEvent() {
        return this == SCHEDULED || this == PREPARATION;
    }

    /**
     * Checks if the match is currently active.
     *
     * @return true if the match is in progress or paused but not concluded.
     */
    public boolean isActive() {
        return this == IN_PLAY || this == PAUSE;
    }

    /**
     * Checks if the match has been concluded.
     *
     * @return true if the match is concluded, results announced, or archived.
     */
    public boolean isConcluded() {
        return this == CONCLUDED || this == RESULTS_ANNOUNCED || this == ARCHIVED;
    }

    /**
     * Checks if the match has been cancelled or aborted.
     *
     * @return true if the match is cancelled or aborted.
     */
    public boolean isCancelledOrAborted() {
        return this == ABORTED;
    }

    /**
     * Checks if the match can transition to the given new state based on the order.
     * Allows for specific cyclical transitions such as between PAUSE and IN_PLAN.
     *
     * @param newState The state to transition to.
     * @return true if the transition is valid, false otherwise.
     */
    public boolean canTransitionTo(MatchState newState) {
        if (this == PAUSE && newState == IN_PLAY) {
            return true;
        }
        return newState.ordinal() >= this.ordinal();
    }

    @Override
    public String toString() {
        return getName();
    }
}