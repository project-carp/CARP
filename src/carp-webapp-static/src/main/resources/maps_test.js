/**
 * Created by mcis on 2016-06-09.
 */

var people = ['Grześka', 'Maćka', 'Zuzi', 'Wojtka', 'Krysi'];

/** Prezentacja tras na podstawie początku i końca trasy oraz zadanych punktów pośrednich, z wykorzystaniem DirectionServices */
function initMap() {
    var directionsService = new google.maps.DirectionsService();
    var infowindow = new google.maps.InfoWindow();
    var center = {lat: 50.072326, lng: 19.888198};
    var zoom = 11;
    var map = new google.maps.Map(document.getElementById('map'), {
        zoom: zoom,
        center: center
    });
    var wp = [];
    wp[0] = {'location': new google.maps.LatLng(50.085954, 19.954416),'stopover':false }
    wp[1] = {'location': new google.maps.LatLng(50.069690, 19.906494),'stopover':false }

    calculateAndDisplayRoute(new google.maps.LatLng(50.135167, 19.636767), new google.maps.LatLng(50.020685, 19.897584), directionsService, map, infowindow, 'red', 0);
    calculateAndDisplayRoute(new google.maps.LatLng(50.093377, 19.890186), new google.maps.LatLng(50.020685, 19.897584), directionsService, map, infowindow, 'green', 1, wp);
    calculateAndDisplayRoute(new google.maps.LatLng(50.024778, 19.984558), new google.maps.LatLng(50.020685, 19.897584), directionsService, map, infowindow, 'blue', 2);
    calculateAndDisplayRoute(new google.maps.LatLng(50.0, 20.0), new google.maps.LatLng(50.020685, 19.897584), directionsService, map, infowindow, 'black', 3);
    calculateAndDisplayRoute(new google.maps.LatLng(50.019182, 19.898828), new google.maps.LatLng(50.020685, 19.897584), directionsService, map, infowindow, 'orange', 4);

    map.setZoom(zoom);
    map.setCenter(center);
}

function calculateAndDisplayRoute(start, end, directionsService, map, infowindow, colour, id, wayPoints) {
    directionsService.route({
        origin: start,
        destination: end,
        waypoints: wayPoints,
        travelMode: google.maps.TravelMode.DRIVING
    }, function(response, status) {
        renderDirections(response, map, infowindow, colour, id);

    });
}

function renderDirections(result, map, infowindow, colour, id) {

    var directionsRenderer = new google.maps.DirectionsRenderer({polylineOptions: { strokeColor: colour }, preserveViewport: true, suppressMarkers:false, routeIndex: id, suppressPolylines:true, infoWindow: infowindow});
    directionsRenderer.setMap(map);
    directionsRenderer.setDirections(result);
    renderDirectionsPolylines(result, map, infowindow, colour, id)
}

function renderDirectionsPolylines(response, map, infowindow, colour, id) {
    var polylineOptions = {
        strokeColor: colour,
        strokeOpacity: 1,
        strokeWeight: 4
    };
    var polylines = [];
    //var newDoc = JXON.unbuild(response);
    var newDoc = JSON.stringify(response);
    //window.alert(newDoc);
    console.log(newDoc);
    //console.log(response);
    var sumCount = 0;
    for (var i=0; i<polylines.length; i++) {
        polylines[i].setMap(null);
    }
    var legs = response.routes[0].legs;
    for (i = 0; i < legs.length; i++) {
        var steps = legs[i].steps;
        for (j = 0; j < steps.length; j++) {
            var segmentCount = 0;
            var nextSegment = steps[j].path;
            var stepPolyline = new google.maps.Polyline(polylineOptions);
            for (k = 0; k < nextSegment.length; k++) {
                stepPolyline.getPath().push(nextSegment[k]);
                //window.alert(' '+ j + ':' + k + ': ' + nextSegment[k]);
                sumCount++;
                segmentCount++;
            }
            //window.alert('Suma segmentu: '+ segmentCount);
            polylines.push(stepPolyline);
            stepPolyline.setMap(map);
            // route click listeners, different one on each step
            google.maps.event.addListener(stepPolyline, 'click', function(evt) {
                infowindow.setContent('Kliknąłeś trasę '+people[id]+'<br><a href="#" onClick="alert(\'Gratulacje! Wybrałeś przewoźnika!\')">Skontaktuj się</a>'); //<br>LatLong: ' + evt.latLng.toUrlValue(6)+'
                infowindow.setPosition(evt.latLng);
                infowindow.open(map);
            })
        }
    }
    //window.alert('Suma sumaryczna: '+ sumCount);
}


/** Prezentacja tras na podstawie punktów trasy (path0-path4) */

function initMap2() {
    var infowindow2 = new google.maps.InfoWindow();
    var center = {lat: 50.072326, lng: 19.888198};
    var zoom = 11;
    var map2 = new google.maps.Map(document.getElementById('map2'), {
        zoom: zoom,
        center: center
    });

    renderPolylines(map2, infowindow2, 'red', 0, path0);
    renderPolylines(map2, infowindow2, 'green', 1, path1);
    renderPolylines(map2, infowindow2, 'blue', 2, path2);
    renderPolylines(map2, infowindow2, 'black', 3, path3);
    renderPolylines(map2, infowindow2, 'orange', 4, path4);

    map2.setZoom(zoom);
    map2.setCenter(center);
}

function renderPolylines(map2, infowindow2, colour, id, pather) {
    var stepPolyline = new google.maps.Polyline({
        path: pather.path,
        strokeColor: colour,
        strokeOpacity: 1,
        strokeWeight: 4});
    stepPolyline.setMap(map2);
    google.maps.event.addListener(stepPolyline, 'click', function(evt) {
        infowindow2.setContent('Kliknąłeś trasę '+people[id]+'<br><a href="#" onClick="alert(\'Gratulacje! Wybrałeś przewoźnika!\')">Skontaktuj się</a>'); //<br>LatLong: ' + evt.latLng.toUrlValue(6)+'
        infowindow2.setPosition(evt.latLng);
        infowindow2.open(map2);
    });
}



