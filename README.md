# Catermelon

Sample project to try out Firebase Database.

My main goal for creating this project was to understand how easy it would be set up a 'server' hosted by Firebase where I can easily send `get` and `post` requests with minimal setup. My only previous experience with this type of setup was with the Parse platform.

Steps I took to get things set up:
1. Create a Firebase project in firebase.console.com
2. Hook up my Firebase project to my Android project (setting it up through the console and adding the project's `google-services.json` file to my Android project)
3. In the Firebase console, create a database for my project.
4. In the Firebase console, Add my first `collection` for my database. (I think of these as "endpoints".) My first collection was `posts`, which I envisioned as an endpoint similar to getting all posts for a social media feed.
5. Once a `collection` was created, I had to create the first `document`. A collection contains multiple documents, so I think of documents like individual JSON objects that return from a get() request. The first `document` looked something like `{ {"description", "First!"}, {"user", "Caren"} }`.
6. Back in the Android app, Firebase is initialized like so:
```kotlin
val db = FirebaseFirestore.getInstance()
```
7. Getting a post looks like:
```kotlin
// Similar to a 'get' request to the {posts} endpoint
db.collection("posts").get().addOnSuccessListener {
    val posts = it.documents
    for (post in posts) {
        Log.i("Caren", "post " + post.get("description") + " " + post.get("timestamp"))
    }
}
```
8. Saving a post looks like:
```kotlin
val samplePost = hashMapOf(
        "description" to "SECOND!",
        "timestamp" to Calendar.getInstance().timeInMillis,
        "user" to "Caren"
)

// Similar to a 'post' request to the {posts} endpoint
db.collection("posts").add(samplePost).addOnSuccessListener {
    Log.i("Caren", "Added new post!")
}
```
