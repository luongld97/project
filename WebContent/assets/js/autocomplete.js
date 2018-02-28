/**
 * @author luog
 */

var searchBox = $('#search-box');
searchBox.autocomplete({
	source: 'api/song/findall',
    select: function( event, ui ) {
        console.log( "Selected: " + ui.item.name );
      }
})