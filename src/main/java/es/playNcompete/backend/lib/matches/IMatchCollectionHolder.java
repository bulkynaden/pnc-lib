package es.playNcompete.backend.lib.matches;

import java.util.Collection;

public interface IMatchCollectionHolder {
    Collection<IMatch<?, ?>> getMatches();

    default <T extends IMatch<?, ?>> void setMatches(Collection<T> matches) {
        matches.forEach(this::addMatch);
    }

    void addMatch(IMatch<?, ?> match);

    void removeMatch(IMatch<?, ?> match);
}