r_brother(alin, alex).
r_brother(alin, ciprian).
r_brother(alex, claudiu).

s_brother(X, Y) :- r_brother(X, Y).
s_brother(X, Y) :- r_brother(Y, X).

brother(L1, L2) :-
    t_brother(L1, L2, []).

t_brother(L1, L2, _) :-
    s_brother(L1, L2).

t_brother(L1, L2, IntermediateNodes) :-
    s_brother(L1, L3),
    \+ member(L3, IntermediateNodes),
    t_brother(L3, L2, [L3 | IntermediateNodes]).

