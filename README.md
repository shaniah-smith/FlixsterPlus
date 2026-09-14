# Flixster+ (Part 1)

Submitted by: Shaniah Smith

Time spent: 3 hours spent in total

## Required Features

The following required functionality is completed:

- [x] User can view a list of movies currently playing in theaters from The Movie Database (TMDB) now playing API.
- [x] Each movie shown in the list includes the movie's title, description, and poster image.
- [x] User can scroll through the list of movies.

## Optional Features

The following optional features are implemented:

- [x] User can see a placeholder graphic while each movie poster is loading, using the Glide image library.
- [x] The app is styled with a custom color theme and card-based layout for each movie row.
- [x] The app responds to orientation changes, switching from a single-column list in portrait to a two-column grid in landscape.

## Video Walkthrough

Here's a walkthrough of implemented user stories:

<img src='FlixsterPlus%20Walkthrough.gif' title='Video Walkthrough' width='250' alt='Video Walkthrough' />

## Notes

Describe any challenges encountered while building the app:

The trickiest part was parsing TMDB's JSON response, since the movie list is nested inside a "results" array rather than being a bare array. I also ran into a dependency version issue where the CodePath AsyncHttpClient version listed in older guides was no longer available, so I had to find the correct current version.

## Open-source libraries used

- [CodePath AsyncHttpClient](https://github.com/codepath/android_guides/wiki/Using-CodePath-Async-Http-Client) - Simplified async HTTP requests
- [Glide](https://github.com/bumptech/glide) - Image loading and caching library for Android
- [Gson](https://github.com/google/gson) - Library for converting Java/Kotlin objects to/from JSON
