document.addEventListener("DOMContentLoaded", function() {
  const notification = document.getElementById("loading-notification");
  notification.style.display = "block";
  setTimeout(function() {
    notification.style.display = "none";
  }, 3000); // Hide the notification after 3 seconds
});