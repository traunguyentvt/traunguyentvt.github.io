$(function () {
    $("#sendBtn").click(updateGuest)
});

function updateGuest() {
    let firstName = $("#firstName").val();
    let lastName = $("#lastName").val();

    $.ajax("guest.ajax", {
        "type": "post",
        "data": {
            "firstName": firstName,
            "lastName": lastName
        }
    }).done(function(data) {
        displayGuests(data);  // Pass the updated data (guest list) to displayGuests
    });
}

function displayGuests(data) {
    let guestList = "<table border='1'><tr><th>First Name</th><th>Last Name</th></tr>"; // Table headers

    // Assuming `data` is an array of guest objects like [{first: "John", last: "Doe"}, ...]
    data.forEach(function(guest) {
        guestList += "<tr><td>" + guest.firstName + "</td><td>" + guest.lastName + "</td></tr>";
    });

    guestList += "</table>";

    // Add the entire list to the DOM
    $("#guestList").html(guestList);
}