# physignathus

Φυσίγναθος

By: Patrick Kingston

🐍 + () + 🇬

## Who is Physignathus

Physignathus, rendered sometimes as "The pouter" because of the meaning "puffed-jaw." He is a character in the excellent text the *Batrachomyomachia* or *War of the frogs and mice*, which is an ancient parody of the Iliad.

It is an ***excellent*** text full of whimsy that I recommend everyone read. :)

## What

Primarily: 

A project designed to assist learners in using the "natural" method of language learning. 
It will allow the user to click on a word, and see useages of the same word in texts that they have read previously, then, it will give them parsing information, and only after this will it give the user the dictionary definition of the word.

Whenever people ask for the definition of a word, what do they immediately say: "Can you use it in a sentence?"
I often find myself looking for the same thing when I'm reading an ancient Greek text, but my greek just isn't good enough to use some of the other resources out there!
Sure, the LSJ references can be useful, but even more useful would be examples of the word being used in a text I have previously read. 
Whenever I'm going through a text like the Iliad (pertinent because it's what I'm going through in the class I'm in right now), I'll come across a word that I just saw in a previous section. 
It would be incredibly valuable for my learning if I were to hunt through the text that I had just read to find the word again, but I usually can't because of time constraints. 
Physignathus will, I hope, fix this issue.

Secondarily:

A project for me to exercise my python skills prior to my first full time programming job :)

---

Φυσίγναθος

---

## TODOs

| Status | Todo |
| --- | --- |
| In progress | Restructure repo to monorepo |

---

Φυσίγναθος

---

## Technical stuff

This project's tech stack is:

### Frontend

| Function | Library/tool | Justification |
| --- | --- | --- |
| Langauge | Clojurescript | I just can't stay away haha |
| Frontend library | Uix2 | It's a nice clojure-idiomatic React wrapper and fast |
| State management | Refx | It's basically re-frame and I think it's the best way to do frontend |
| Styling | Tailwind | Another thing I want to learn better |

Why clojure for the frontend? Well I had planned at one point to make this app with vue and the rest of the scaife tooling, but I'm using clojure because:
1. I just can't bear to write javascript. 
2. The demands of this app are beyond the scope of what the Scaife project has to offer and potentially wants to/should offer? I.e. customizable user pages and associated features.
3. I want clojure to be more in use and one of the best ways of doing that is by making things people use in clojure.

### Backend

| Function | Library/tool | Justification |
| --- | --- | --- |
| Language | Python | It's the backend language of the rest of the rest of the project, and what I'm trying to learn better |
| Web framework | fastapi | It's fast and simple |
| Authorization | oauth2 | I want to offer users maximum flexibility in login options |
| Database | sqlite | It's simple enough, and fast enough, for this application |

Why not Django for the backend, in line with the rest of the Scaife project? Well, having used Django before I have 2 reasons to reject it:

1. I want fewer moving parts (i.e. django has too much magic)
2. I want something that can more easily "swap out" parts

Using plain fastapi and sqlite means that in the future, I can switch it to another sqlite library or database system very easily, switch to another web framework like flask, etc. Django very much ties you down to the Django way of doing things, which is fine in many aspects and is how I learned web development, but I want to at least *try* this way first.

Further, as a learning project, FastApi forces me to get to know python's type anotation system. 
